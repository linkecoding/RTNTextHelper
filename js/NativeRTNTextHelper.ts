import { TurboModule, TurboModuleRegistry } from "react-native";

export type TextInfo = {
    text: string
    fontSize: number
    fontFamily?: string
}

export type MeasureResult = {
    width: number
}

export interface Spec extends TurboModule {
    measureTextAsync(textInfo: TextInfo): Promise<MeasureResult>;
    measureTextSync(textInfo: TextInfo): MeasureResult;
}

export default TurboModuleRegistry.get<Spec>("RTNTextHelper") as Spec | null;