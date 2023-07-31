import { IExchangeAnimal } from "./exchange-animal";

export interface IExhibitApiResponse {
    exhibits: IExhibit[]
}

export interface IExhibit {
    uuid: string;
    name: string;
    spacesUsed: number;
    animals: IExchangeAnimal[];
    catalog?: any[];
}