#include <bits/stdc++.h>
#define lp(n) for(int i = 0; i < n; i++)
#define lpp(i, n) for(int i = 0; i < n; i++)

using namespace std;
int main() {
  int a[100];
  int n, c=0;
  cin >> n;
  lp(n) cin >> a[i];
  int minj;
  lp(n) {
    minj = i;
    for(int j = i; j <= n-1; j++) {
      if(a[j] < a[minj]) minj = j;
    }
    if(i != minj) c++;
    swap(a[i], a[minj]);
  }
  lp(n) {
    cout << a[i] << ((i == n-1) ? "\n" : " ");
  }
  cout << c << endl;
  
  return 0;
}

