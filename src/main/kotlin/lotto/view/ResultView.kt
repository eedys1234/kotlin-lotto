package lotto.view

import lotto.domain.Lotto
import lotto.domain.Rank

class ResultView {

    companion object {
        fun printPurchaseLotto(lottos: List<Lotto>) {
            println("${lottos.size}개를 구매했습니다")
            println(lottos.joinToString { "\n" })
        }

        fun printStatistics(statistic: Map<Rank, MutableList<Lotto>>, amount: Int)  {
            println("당첨 통계")
            println("---------")

            var totalWinAmount: Long = 0
            for(rank in statistic.keys) {
                if(rank == Rank.MISS) continue
                totalWinAmount += rank.amount
                println("${rank.count}개 일치 (${rank.amount}원) - ${statistic[rank]?.size}개")
            }

            val rate = (totalWinAmount/amount) * 100
            println("총 수익률은 ${rate}입니다.")
        }
    }
}