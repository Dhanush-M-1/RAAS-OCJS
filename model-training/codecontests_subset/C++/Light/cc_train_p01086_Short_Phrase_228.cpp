#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

#define reps(i,f,n) for(int i=f; i<n; ++i)
#define rep(i,n) reps(i,0,n)

void solve(int n)
{
    vector<int> v(n);
    
    rep(i, n){
        string s;
        cin >> s;
        v[i] = s.size();
    }
    
    const int len[] = {5, 7, 5, 7, 7};
    rep(i, n){
        int p = 0, j = i;
        while(p < 5 && j < n){
            int cnt = len[p];
            for(; cnt && j<n; ++j){
                cnt -= v[j];
                if(cnt < 0) goto end;
            }
            ++p;
        }
        
        if(p == 5){
            cout << i+1 << endl;
            break;
        }
    end:;
    }
}

int main()
{
    int n;
    
    while(cin >> n, n){
        solve(n);
    }
}