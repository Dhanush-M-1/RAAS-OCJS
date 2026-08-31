#include <bits/stdc++.h>
using namespace std;
const int MAXN = 55;
int N, X[MAXN], Y[MAXN], R;
void ps1(int t) {
  if (t < 0)
    cout << t;
  else
    cout << "+" << t;
}
void ps(int t) {
  if (t < 0)
    cout << "-(" << -t;
  else
    cout << "+(" << t;
}
void solve(int *A) {
  cout << "(0";
  int slope = 0, cur = 0;
  for (int i = 0; i < N; i++) {
    if (A[i] % 2) A[i] += 1;
    int nslope = A[i] - cur;
    int k = (nslope - slope) / 2;
    if (i == N - 1) {
      cout << "+(0";
    } else {
      cout << "+((0";
    }
    ps(k);
    cout << "*(t";
    ps(1 - i);
    if (1 - i < 0)
      cout << "-";
    else
      cout << "+";
    cout << "abs((t";
    ps1(1 - i);
    if (i == N - 1) {
      cout << ")))))";
    } else {
      cout << "))))))";
    }
    slope = nslope;
    cur = A[i];
    cerr << slope << endl;
  }
  for (int i = 0; i < N; i++) {
    cout << ")";
  }
  cout << ")\n";
}
int main() {
  cin >> N;
  for (int i = 0; i < N; i++) {
    cin >> X[i] >> Y[i] >> R;
  }
  solve(X);
  solve(Y);
}
