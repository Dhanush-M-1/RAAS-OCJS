#include <bits/stdc++.h>
using namespace std;

int a[200200];
int main() {
  int n;
  cin >> n;
  for(int i=0; i<n; i++) {
    int x,y;
    cin >> x >> y;
    a[x+y]++;
  }
  for(int i=0; i<200100; i++) {
    a[i+1]+=a[i]/2;
    a[i]%=2;
    if(a[i]) cout << i << " " << 0 << endl;
  }
  return 0;
}
