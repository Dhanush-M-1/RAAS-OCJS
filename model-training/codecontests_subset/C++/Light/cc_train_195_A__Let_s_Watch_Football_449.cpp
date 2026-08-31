#include <bits/stdc++.h>
using namespace std;
long long N, A, B;
long long All;
bool MySort(const pair<int, int>& A, const pair<int, int>& B) {
  return A.first > B.first;
}
bool Check(long long M) {
  long long X = M * A;
  X += (A * B);
  if (X < All) return false;
  return true;
}
int main() {
  cin >> N >> A >> B;
  All = N * B;
  long long L = 1, R = 1e8;
  long long Ans = 1e8;
  while (R >= L) {
    long long M = (R + L) / 2;
    if (Check(M)) {
      Ans = min(Ans, M);
      R = M - 1;
    } else {
      L = M + 1;
    }
  }
  cout << Ans << endl;
  return 0;
}
