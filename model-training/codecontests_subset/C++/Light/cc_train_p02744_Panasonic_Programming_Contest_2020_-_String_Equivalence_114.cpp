#include <bits/stdc++.h>
using namespace std;
int n;
void solve(string s, int a, int b){
    if(a == n) cout << s << endl;
    else for(int i=0; i<=b; i++){
        string t = s; t.push_back((char)('a'+i));
        solve(t,a+1,max(b,i+1));
    }
}
int main(){ cin >> n; solve("a",1,1); }