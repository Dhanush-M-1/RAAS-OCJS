#include<bits/stdc++.h>
#define rep(i,a,b) for(int i=int(a);i<int(b);++i)
using namespace std;
typedef long long ll;
int INF = (1LL << 30) - 1;
int MOD = 1e9+7;
void solve(int N){
    vector<int> V(N);
    rep(i,0,N){
        string s;
        cin >> s;
        V[i] = s.size();
    }
    int arr[] = {5,7,5,7,7};
    rep(i,0,N){
        int sum = 0, cur = 0;
        bool ok = 1;
        rep(j,i,N){
            sum += V[j];
            if(sum > arr[cur]){
                ok = 0;
                break;
            }else if(sum == arr[cur]){
                cur++;
                sum = 0;
            }
            if(cur == 5)break;
        }
        if(!ok || cur != 5)continue;
        cout << i+1 << endl;
        return;
    }
}
int main(){
    int N;
    cin >> N;
    while(N){
        solve(N);
        cin >> N;
    }
}
