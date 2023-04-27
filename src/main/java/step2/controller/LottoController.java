package step2.controller;

import step2.domain.LottoService;
import step2.domain.LottoStoreService;
import step2.domain.ProfitCalculatorService;
import step2.domain.strategy.price.LottoPriceStrategy;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoController {
    public static void main(String[] args) {
        int purchaseAmount = InputView.askPurchaseAmount();
        int lottoCount = LottoStoreService.getLottoCount(new LottoPriceStrategy(), purchaseAmount);
        OutputView.outPut(lottoCount);

        InputView.newLineRemove();

        LottoService lottoService = LottoService.of(lottoCount, InputView.askLastWeekWinningNumbers());
        lottoService.calculatorLottoWinningCount();

        ProfitCalculatorService from = ProfitCalculatorService.of(lottoService.getLottos(), purchaseAmount);
        OutputView.outPutProfit(from.getProfit(), from.getWinningCount());
    }
}
