export enum ContentState {
    LOADING, LOADED, ERROR
}

export interface ApiObservable<T> {
    state: ContentState,
    data?: T,
    error?: any
}