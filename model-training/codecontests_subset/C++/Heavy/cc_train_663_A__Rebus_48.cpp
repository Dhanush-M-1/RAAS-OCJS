#include <bits/stdc++.h>
using namespace std;
int II() {
  int q;
  scanf("%d", &q);
  return q;
}
long long LII() {
  long long q;
  scanf("%lld", &q);
  return q;
}
long long search(long long baki, long long sum, long long mot, long long N) {
  long long l = 1, r = N;
  long long re = 1;
  while (l <= r) {
    long long mid = (l + r) / 2;
    if ((sum + mid + baki) <= mot) {
      re = mid;
      l = mid + 1;
    } else
      r = mid - 1;
  }
  return re;
}
long long search_neg(long long baki, long long neg_sum, long long pos_sum,
                     long long N) {
  long long l = 1, r = N, re = 1;
  while (l <= r) {
    long long mid = (l + r) / 2;
    if ((neg_sum + mid + baki) <= (pos_sum - N)) {
      re = mid;
      l = mid + 1;
    } else
      r = mid - 1;
  }
  return re;
}
void solve() {
  long long pos = 0, neg = 0;
  vector<char> v;
  long long N;
  v.push_back('+');
  while (1) {
    char c1, c2;
    cin >> c1 >> c2;
    if (c2 == '=') {
      cin >> N;
      break;
    }
    v.push_back(c2);
  }
  for (auto it : v) {
    if (it == '+')
      pos++;
    else
      neg++;
  }
  if ((((pos * N) - neg) < N) or (pos - (N * neg)) > N) {
    cout << "Impossible" << endl;
    return;
  }
  long long mot = N + neg;
  vector<long long> v1;
  long long sum = 0;
  for (long long i = 1; i <= pos; i++) {
    long long q = search(pos - i, sum, mot, N);
    sum += q;
    v1.push_back(q);
  }
  long long neg_sum = 0;
  vector<long long> v2;
  for (long long i = 1; i <= neg; i++) {
    long long q = search_neg(neg - i, neg_sum, sum, N);
    neg_sum += q;
    v2.push_back(q);
  }
  if ((sum - neg_sum) != N) {
    cout << "Impossible" << endl;
    return;
  }
  long long w1 = 0, w2 = 0;
  cout << "Possible" << endl;
  for (long long i = 0; i < v.size(); i++) {
    if (v[i] == '+') {
      if (i == 0) {
        cout << v1.back() << " ";
      } else {
        cout << "+ " << v1.back() << " ";
      }
      w1 += v1.back();
      v1.pop_back();
    } else {
      cout << "- " << v2.back() << " ";
      w2 += v2.back();
      v2.pop_back();
    }
  }
  cout << "= " << N << endl;
}
int32_t main() {
  long long tt;
  tt = 1;
  while (tt--) {
    solve();
  }
}
