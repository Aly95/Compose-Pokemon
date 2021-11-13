package pokemon.slick.di

import com.alyhuggan.pokemon.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pokemon.slick.data.api.PokemonService
import pokemon.slick.data.repository.PokemonRemoteDataSourceImpl
import pokemon.slick.data.repository.PokemonRepository
import pokemon.slick.data.repository.datasource.PokemonRemoteDataSource
import pokemon.slick.data.repository.datasource.PokemonRepositoryImpl
import pokemon.slick.data.repository.usecase.GetPokemonUseCase
import javax.inject.Singleton

/*
Dagger-Hilt Application Modules
 */
@Module
@InstallIn(SingletonComponent::class)
class ActivityModule {

    @Provides
    @Singleton
    fun providePokemonRepository(pokemonRepository: PokemonRepositoryImpl): PokemonRepository = pokemonRepository

    @Provides
    @Singleton
    fun provideGetPokemonUseCase(pokemonRepository: PokemonRepository): GetPokemonUseCase = GetPokemonUseCase(pokemonRepository)

    @Provides
    @Singleton
    fun providePokemonRepositoryImpl(dataSource: PokemonRemoteDataSource): PokemonRepositoryImpl = PokemonRepositoryImpl(dataSource)

    @Provides
    @Singleton
    fun providePokemonRemoteDataSource(pokemonRemoteDataSource: PokemonRemoteDataSourceImpl): PokemonRemoteDataSource = pokemonRemoteDataSource

    @Provides
    @Singleton
    fun providePokemonService(apiKey: String, pokemonService: PokemonService): PokemonRemoteDataSourceImpl = PokemonRemoteDataSourceImpl(apiKey, pokemonService)

    @Provides
    @Singleton
    fun provideApiKey() = BuildConfig.API_KEY
}