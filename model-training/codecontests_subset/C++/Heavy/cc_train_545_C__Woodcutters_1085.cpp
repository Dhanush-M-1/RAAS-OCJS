#include <bits/stdc++.h>
using namespace std;
map<long long, long long>::iterator itr;
void c_p_c() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
}
void ans() {
  long long num;
  cin >> num;
  vector<pair<long long, long long>> A;
  for (long long i = 0; i < num; i++) {
    long long x, y;
    cin >> x >> y;
    A.push_back(make_pair(x, y));
  }
  sort(A.begin(), A.end());
  if (num <= 2) {
    cout << num;
    return;
  }
  long long c = 2;
  for (long long i = 1; i < num - 1; i++) {
    if (A[i].first - A[i - 1].first > A[i].second)
      c++;
    else if (A[i + 1].first - A[i].first > A[i].second) {
      c++;
      A[i].first += A[i].second;
    }
  }
  cout << c;
}
int32_t main() {
  c_p_c();
  ans();
}
