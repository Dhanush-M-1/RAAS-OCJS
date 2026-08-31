#include <bits/stdc++.h>
using namespace std;
long long T, t, n, N, l, L, R;
vector<int> v;
pair<int, int> calcL() {
  for (n = l = 0; n < N; n++) {
    if ((l + (N - (n + 1))) > (L / 2)) break;
    l += (N - (n + 1));
  }
  return pair<int, int>(n, 1 + n + (int)((L / 2) - l));
}
void fill() {
  v.clear();
  pair<int, int> curr = calcL();
  for (n = L; n <= R; n++) {
    if (curr.first >= (N - 1)) {
      curr.first = 0;
    }
    if (curr.second >= N) {
      curr.second = 0;
    }
    if (n & 1) {
      v.push_back(curr.second);
      if (curr.second == (N - 1)) {
        curr = pair<int, int>((curr.first + 1), (curr.first + 2));
      } else
        curr.second++;
    } else
      v.push_back(curr.first);
  }
}
int main() {
  cin >> T;
  for (t = 0; t < T; t++) {
    cin >> N >> L >> R;
    L--;
    R--;
    fill();
    for (n = 0; n <= (R - L); n++) {
      printf("%d ", 1 + v[n]);
    }
    printf("\n");
  }
  return 0;
}
