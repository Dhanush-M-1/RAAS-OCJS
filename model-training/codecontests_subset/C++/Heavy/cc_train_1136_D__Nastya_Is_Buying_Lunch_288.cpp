#include <bits/stdc++.h>
using namespace std;
int order[300010];
vector<int> canChange[300010];
int canYield[300010];
int cantOvertake[300010];
int main(void) {
  int N, M, cnt;
  cin >> N >> M;
  cnt = 0;
  for (int i = 0; i < N; i++) cin >> order[i];
  for (int i = 0; i < M; i++) {
    int a, b;
    cin >> a >> b;
    canChange[a].push_back(b);
    if (b == order[N - 1]) canYield[a] = 1;
  }
  for (int i = N - 2; i >= 0; i--) {
    int cur = order[i];
    if (canYield[cur]) {
      int cnt2 = 0;
      for (int j : canChange[cur]) cnt2 += cantOvertake[j];
      if (cnt2 != cnt) {
        cantOvertake[cur] = 1;
        cnt++;
      }
    } else {
      cantOvertake[cur] = 1;
      cnt++;
    }
  }
  cout << N - 1 - cnt << endl;
  return 0;
}
