#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
using namespace std;
typedef long long int ll;

int main(){
    cin.tie(nullptr);
    ios::sync_with_stdio(false);
    int q; cin >> q;
    while(q--){
        int n; cin >> n;
        map<int,int> used;
        int cnt=0;
        while(n>=10){
            int ma=0;
            for(int i=10;;i*=10){
                if(n<i)break;
                ma=max(ma,(n%i)*(n/i));
            }
            if(used[ma]){
                cnt=-1;
                break;
            }
            used[ma]=1;
            cnt++;
            n=ma;
        }
        cout << cnt << endl;
    }
}
