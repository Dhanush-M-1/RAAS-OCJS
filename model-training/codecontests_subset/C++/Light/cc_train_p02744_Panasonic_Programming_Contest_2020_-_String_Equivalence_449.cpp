#include <bits/stdc++.h>
using namespace std;
int n,a; string s;
void solve(int b){
    if(a == n) cout << s << endl;
    else for(int i=0; i<=b; i++){
        s.push_back((char)('a'+i)); a++;
        solve(max(b,i+1));
        s.pop_back(); a--;
    }
}
int main(){ cin >> n; solve(0); }