#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef pair<int, int> P;

#define pb push_back
#define rep(i, a, n) for(int i = (a); i < (n); i++)
#define dep(i, a, n) for(int i = (a); i >= (n); i--)
#define mod 1e9+7

__attribute__((constructor))
void initial() {
  cin.tie(0);
  ios::sync_with_stdio(false);
}

int main() {
  int n;
  cin >> n;
  int aa[500001] = {};
  rep(i, 0, n) {
    int a, b;
    cin >> a >> b;
    aa[a + b]++;
  }

  rep(i, 0, 500000) {
    if(aa[i]) {
      aa[i + 1] += aa[i] / 2;
      if(aa[i] % 2 == 1) cout << i << " " << 0 << endl;
    }
  }
}