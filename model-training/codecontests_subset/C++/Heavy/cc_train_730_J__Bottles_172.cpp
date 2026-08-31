#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1000000007LL;
vector<vector<int> > array2_int(int N, int M, int def = 0) {
  return vector<vector<int> >(N, vector<int>(M, def));
}
vector<vector<vector<int> > > array3_int(int N, int M, int K, int def = 0) {
  return vector<vector<vector<int> > >(
      N, vector<vector<int> >(M, vector<int>(K, def)));
}
vector<vector<long long> > array2_ll(int N, int M, long long def = 0) {
  return vector<vector<long long> >(N, vector<long long>(M, def));
}
vector<vector<vector<long long> > > array3_ll(int N, int M, int K,
                                              long long def = 0) {
  return vector<vector<vector<long long> > >(
      N, vector<vector<long long> >(M, vector<long long>(K, def)));
}
template <class T>
void printImpl(const vector<T>& coll) {
  copy(coll.begin(), coll.end(), ostream_iterator<T>(cout, " "));
  cout << endl;
}
template <class T, int N>
void printImpl(T (&coll)[N]) {
  copy(coll, coll + N, ostream_iterator<T>(cout, " "));
  cout << endl;
}
template <class Key, class Value>
void printImpl(const map<Key, Value>& data) {
  typename map<Key, Value>::const_iterator it;
  for (it = data.begin(); it != data.end(); ++it) {
    cout << it->first << ":" << it->second << endl;
  }
}
template <class T>
void printImpl(const T& data) {
  cout << data << endl;
}
int N;
int totalB;
void update(vector<vector<int> >& dp, int a, int b) {
  vector<vector<int> > newDp(dp);
  for (int used = 1; used < N; ++used) {
    for (int sumB = 1; sumB + b <= totalB; ++sumB) {
      if (dp[used][sumB]) {
        newDp[used + 1][sumB + b] =
            max(dp[used + 1][sumB + b], dp[used][sumB] + a);
      }
    }
  }
  newDp[1][b] = max(dp[1][b], a);
  swap(dp, newDp);
}
int main() {
  cin >> N;
  vector<int> a(N), b(N);
  for (int i = 0; i < (N); ++i) cin >> a[i];
  for (int i = 0; i < (N); ++i) cin >> b[i];
  int totalA = 0;
  totalB = 0;
  for (int i = 0; i < (N); ++i) totalA += a[i];
  for (int i = 0; i < (N); ++i) totalB += b[i];
  vector<vector<int> > dp = array2_int(N + 1, totalB + 1);
  for (int ix = 0; ix < N; ++ix) {
    update(dp, a[ix], b[ix]);
  }
  vector<int> bb(b);
  sort(bb.begin(), bb.end(), greater<int>());
  int curr = 0;
  int need = 0;
  for (int i = 0; i < N; ++i) {
    curr += bb[i];
    if (curr >= totalA) {
      need = i + 1;
      break;
    }
  }
  int canDo = 0;
  for (int sb = totalA; sb <= totalB; ++sb) {
    canDo = max(canDo, dp[need][sb]);
  }
  cout << need << " " << totalA - canDo << endl;
  return 0;
}
