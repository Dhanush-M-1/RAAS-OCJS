#include <bits/stdc++.h>
using namespace std;

int n;

void f(string s, int sl){
    if (s.size() == n){
        cout << s << '\n';
        return;
    }
    for (int i = 0; i < sl; i++){
        f(s+(char)('a'+i), sl);
    }
    f(s+(char)('a'+sl), sl+1);
}

int main(){

    cin >> n;
    f("a", 1);

}