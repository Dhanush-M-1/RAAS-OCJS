#include <bits/stdc++.h>
using namespace std;

int main() {
  int N, M;
  cin >> N >> M;
  int a[60], b[60], c[60], d[60];
  for (int i = 0; i < N; i++) cin >> a[i] >> b[i];
  for (int i = 0; i < M; i++) cin >> c[i] >> d[i];

  for (int i = 0; i < N; i++) {
    int mini = 1000000000, p = -1;
    for (int j = 0; j < M; j++) {
      int m = abs(a[i] - c[j]) + abs(b[i] - d[j]);
      if (m < mini) {
        p = j + 1;
        mini = m;
      }
    }
    cout << p << endl;
  }
}