#include <bits/stdc++.h>
using namespace std;

#define ll long long

signed main() {
  int a,b,c;
  cin >> a >> b >> c;
  puts((a+b==c)||(a+c==b)||(b+c==a)? "Yes":"No");
}