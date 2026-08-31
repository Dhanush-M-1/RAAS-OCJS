#include <iostream>
#include <stdio.h>
#include <algorithm>
#include <vector>
#include <queue>
#include <numeric>
#include <string>
#include <string.h>
#include <map>
#include <set>
#include <functional>
#include <complex>

using namespace std;

const int INF = (1<<30) - 1;


int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int Q; cin >> Q;
    while(Q--){
        int R; cin >> R;
        int ans = 0;
        while(R >= 10){
            int next = 0;
            for(int x=10; x<=R; x*=10){
                next = max(next, (R/x) * (R%x));
            }
            R = next;
            ans++;
        }
        cout << ans << endl;
    }
    
    return 0;
}