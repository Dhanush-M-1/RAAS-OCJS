#include <bits/stdc++.h>
using namespace std;

#define FOR(i, a, b) for (int i = (a); i < (b); i++)
#define REP(i, n) for (int i = 0; i < (n); i++)

int main()
{
  int n;
  while (cin >> n, n){
    int a[n], cnt = 0;
    REP(i, n) cin >> a[i];
    for (int i = n; i > 0; i--){
      for (int j = 0; j < i - 1; j++){
        if (a[j] > a[j + 1]){
          swap(a[j], a[j + 1]);
          cnt++;
        }
      }
    }
    cout << cnt << endl;
  }
}