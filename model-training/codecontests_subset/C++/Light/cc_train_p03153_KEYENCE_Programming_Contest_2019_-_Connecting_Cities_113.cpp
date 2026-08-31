// includes {{{
#include<iostream>
#include<iomanip>
#include<algorithm>
#include<vector>
#include<stack>
#include<queue>
#include<map>
#include<set>
#include<tuple>
#include<cmath>
#include<random>
#include<cassert>
// #include<deque>
// #include<multiset>
// #include<bitset>
// #include<cstring>
// #include<bits/stdc++.h>
// }}}
using namespace std;
using ll = long long;

int n;
ll d;
const int N = 2e5;
int a[N];
ll le[N], ri[N];
ll le2[N], ri2[N];

// smin, smax {{{
// clang-format off
template < class T, class U > inline void smin(T &a, const U &b) { a = a < (T) b ? a : b; }
template < class T, class U > inline void smax(T &a, const U &b) { a = a < (T) b ? b : a; }
// clang-format on
// }}}

// 連結性の証明 :
// 左へ伸ばすものについては，
// 左から伸ばしたものをつなげて，
// 右へ伸ばす頂点を新しく引きずる

// 最小性の証明 :
// それぞれの頂点は選択をしなければいけない
// その選択を制限の範囲で自由にできる
// ごめんちょっとよくわからない

int main() {
  ios::sync_with_stdio(false), cin.tie(0);
  cin >> n >> d;
  for(int i = 0; i < n; i++) {
    cin >> a[i];
    le[i] = ri[i] = a[i];
    le[i] += -i * d;
    ri[i] += i * d;
    le2[i] = le[i];
    ri2[i] = ri[i];
  }
  for(int i = 1; i < n; i++) smin(le[i], le[i-1]);
  for(int i = n - 2; i >= 0; i--) smin(ri[i], ri[i+1]);
  ll ans = 0;
  for(int i = 0; i < n; i++) {
    if(i == 0) {
      ans += le2[i];
    } else if (i == n - 1) {
      ans += ri2[i];
    } else {
      ans += min(ri2[i] + le[i], le2[i] + ri[i]);
    }
  }
  cout << ans << endl;
  return 0;
}
