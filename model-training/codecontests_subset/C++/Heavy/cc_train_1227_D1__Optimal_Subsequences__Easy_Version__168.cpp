#include <bits/stdc++.h>
using namespace std;
void Update(const long &);
long FindSum(const long &);
long N, M, K = 0;
vector<long> BIT;
int main() {
  cin >> N;
  vector<pair<long, long>> A(N + 1);
  vector<long> X(N + 1);
  for (long i = 1; i <= N; ++i) {
    cin >> A[i].first;
    A[i].second = i;
    X[i] = A[i].first;
  }
  cin >> M;
  vector<pair<pair<long, long>, long>> Q(M);
  for (long i = 0; i < M; ++i) {
    cin >> Q[i].first.first >> Q[i].first.second;
    Q[i].second = i;
  }
  sort(A.begin() + 1, A.end(),
       [&](const pair<long, long> &X, const pair<long, long> &Y) -> bool {
         if (X.first != Y.first)
           return X.first > Y.first;
         else
           return X.second < Y.second;
       });
  sort(Q.begin(), Q.end());
  BIT.resize(N + 1, 0);
  vector<long> Answer(M);
  for (long i = 0; i < M; ++i) {
    while (K < Q[i].first.first) {
      ++K;
      Update(A[K].second);
    }
    Answer[Q[i].second] = X[FindSum(Q[i].first.second)];
  }
  for (long &x : Answer) cout << x << '\n';
  flush(cout);
}
void Update(const long &I) {
  for (long i = I; i <= N; i += (i & -i)) ++BIT[i];
}
long FindSum(const long &S) {
  long pos = 0, sum = 0, next;
  for (long i = 17; i >= 0; --i) {
    next = pos + (1 << i);
    if ((next <= N) && (sum + BIT[next] < S)) {
      pos = next;
      sum += BIT[pos];
    }
  }
  return pos + 1;
}
