#include <bits/stdc++.h>
using namespace std;
int n;
int N, M;
string words[1000011];
int lens[1000011];
int sumLens[1000011];
int maxNext[1000011][21];
int MAIN() {
  while (cin >> n >> N >> M) {
    for (int i = 1; i <= n; i++) {
      cin >> words[i];
      lens[i] = words[i].length();
    }
    memset(sumLens, 0, sizeof(sumLens));
    for (int i = 1; i <= n; i++) {
      sumLens[i] = lens[i] + sumLens[i - 1];
    }
    int pos = 1;
    for (int i = 0; i <= 20; i++) maxNext[n + 1][i] = n + 1;
    for (int i = 1; i <= n; i++) {
      while (pos <= n && sumLens[pos] - sumLens[i - 1] + (pos - i) <= M) pos++;
      maxNext[i][0] = pos;
    }
    for (int i = 1; i <= 20; i++)
      for (int j = 1; j <= n; j++)
        maxNext[j][i] = maxNext[maxNext[j][i - 1]][i - 1];
    int maxAns = -1, startWith;
    for (int i = 1; i <= n; i++) {
      int p = i;
      for (int j = 0; j <= 20; j++)
        if ((N & (1 << j)) > 0) {
          p = maxNext[p][j];
        }
      if (p - i > maxAns) {
        maxAns = p - i;
        startWith = i;
      }
    }
    int p = startWith;
    for (int i = 1; i <= N; i++) {
      for (int j = p; j < maxNext[p][0]; j++)
        cout << words[j] << (j == maxNext[p][0] - 1 ? "\n" : " ");
      p = maxNext[p][0];
    }
  }
  return 0;
}
int main() {
  ios ::sync_with_stdio(false);
  cout << fixed << setprecision(16);
  return MAIN();
}
