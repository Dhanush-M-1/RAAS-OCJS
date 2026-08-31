#include <bits/stdc++.h>

using namespace std;

int main(){
 int a=0,b=0,c=0;
 cin >> a >> b >> c;
 cout << (max(max(a,b),c)*2==a+b+c?"Yes":"No") << endl;
 return 0;
}