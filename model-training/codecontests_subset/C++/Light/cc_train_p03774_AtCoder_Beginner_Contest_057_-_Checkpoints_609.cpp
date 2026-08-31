#include <bits/stdc++.h>
using namespace std;
int main() {
  int N,M;
  cin >> N >> M;
  int a[N], b[N], c[M], d[M];
  for (int i = 0; i < N; i++) {
    cin >> a[i] >> b[i];
  }
  for (int i = 0; i < M; i++) {
    cin >> c[i] >> d[i];
  }
  for (int i = 0; i < N; i++) {
    int x = INT_MAX, y;
    for (int j = 0; j < M; j++) {
      if (abs(a[i]-c[j])+abs(b[i]-d[j]) < x) {
        x = abs(a[i]-c[j])+abs(b[i]-d[j]);
        y = j+1;
      }
    }
    cout << y << endl;
  }
}