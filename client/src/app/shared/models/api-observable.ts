export enum ContentState {
    LOADING, LOADED, ERROR
}

export interface ApiObservable<T> {
    state: ContentState,
    data?: T // make this a generic,
    error?: any
}