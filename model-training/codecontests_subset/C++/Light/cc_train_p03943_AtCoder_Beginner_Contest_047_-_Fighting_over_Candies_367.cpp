#include <bits/stdc++.h>
using namespace std;

int main(){
    int a,b,c;
    cin >> a >> b >> c;
    int x = max(a,max(b,c));
    cout << (x == a+b+c-x ? "Yes" : "No") << endl;
}