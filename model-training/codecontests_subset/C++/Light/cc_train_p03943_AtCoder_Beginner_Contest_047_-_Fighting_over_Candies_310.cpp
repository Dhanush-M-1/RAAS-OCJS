#include <bits/stdc++.h>
using namespace std;
 
int main() {
  int a,b,c;
  cin >> a >> b >> c;
  int ma;
  ma = max({a,b,c});
  cout << (ma == a+b+c-ma? "Yes":"No");
}