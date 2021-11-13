package pokemon.slick.utils

data class NetworkStatus<out T>(val status: Status, val data: T?, val message: String?) {

    companion object{
        fun <T> success(data: T?): NetworkStatus<T> {
            return NetworkStatus(Status.SUCCESS, data, null)
        }
        fun <T> error(msg: String, data: T?): NetworkStatus<T> {
            return NetworkStatus(Status.ERROR, data, msg)
        }
        fun <T> loading(data: T?): NetworkStatus<T> {
            return NetworkStatus(Status.LOADING, data, null)
        }
    }
}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}