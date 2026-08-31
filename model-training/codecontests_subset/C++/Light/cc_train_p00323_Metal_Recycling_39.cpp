
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
  int a[300001] = {};
  rep(i, 0, n) {
    int b, c;
    cin >> b >> c;
    a[b + c]++;
  }
  rep(i, 0, 300001) {
    if(a[i] >= 2) {
      a[i + 1] += a[i] / 2;
      a[i] = a[i] % 2;
    }
  }
  rep(i, 0, 300001) {
    if(a[i]) cout << i << " " << 0 << endl;
  }
}