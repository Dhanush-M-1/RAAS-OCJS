#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define t64 int64_t
#define rep(i,a,b) for(int i=a;i<b;i++)
#define FOR(i,a,b) for(int i=a;i<b;i++)
#define FORe(i,a,b) for(int i=a;i<=b;i++)
#define FORr(i,a,b) for(int i=a;i>b;i--)
#define FORre(i,a,b) for(int i=a;i>=b;i--)
#define pb push_back
#define imie(...) " [" << #__VA_ARGS__ ": " << (__VA_ARGS__) << "] "

const ll inf = 1e9+7;

t64 ceil_div(t64 a,t64 b){
    t64 ans = a/b;
    if(a%b != 0)ans++;
    return ans;
}

void solve(){
    int n,m; cin >> n >> m;
    vector<t64>a(n);
    vector<t64>pref(n);
    vector<pair<t64,int> > maxes;
    rep(i,0,n){
        cin >> a[i];
    }
    pref[0] = a[0];
    maxes.pb(pair<t64,int>(a[0],0));
    rep(i,1,n){
        pref[i] = pref[i-1]+a[i];
        if(pref[i] > maxes.back().first){
            maxes.pb(pair<t64,int>(pref[i],i));
        }
    }
    t64 x;
    rep(i,0,m){
        cin >> x;
        t64 ans = 0;
        if(x <= maxes.back().first){
            // cout << "C1\n";
            ans = lower_bound(maxes.begin(),maxes.end(),pair<t64,int>(x,0))->second + 1;
        }
        else{
            if(pref[n-1] <= 0){
            // cout << "C2\n";
            ans = 0;}
            else{
                t64 aux = x - maxes.back().first;
                t64 num = ceil_div(aux,pref[n-1]);
                x -= (num * pref[n-1]);
                ans = num * n;
                ans += lower_bound(maxes.begin(),maxes.end(),pair<t64,int>(x,0))->second + 1;
            }
        }
        cout << ans -1 << " ";
    }
    cout << endl;
}

void solve2(){
    int n,m; cin >> n >> m;
    t64 total_sum = 0;
    t64 highest_sum = 0;
    int highest_sum_moves = 0;
    map<t64,int> sums;
    vector<t64> a(n);
    rep(i,0,n){
        cin >> a[i];
        total_sum += a[i];
        if(sums[total_sum] == 0){
            sums[total_sum] = i;
        }
        highest_sum = max(highest_sum,total_sum);
        if(total_sum > highest_sum){
            highest_sum = total_sum;
            highest_sum_moves = i;
        }
    }
    vector<t64> x(m); rep(i,0,m) cin >> x[i];
    // cout << imie(total_sum) << endl;
    if(total_sum <= 0){
        for(auto v: x){
            if(v > highest_sum){
                cout << -1 << " ";
            }
            else{
                int ans = inf;
                map<t64,int>::iterator it;
                for(it = sums.end()--;it != sums.begin(); it--){
                    if(it->first >= v){
                        ans = min(ans, it->second);
                    }
                    else break;
                }
                if(it->first >= v){
                    ans = min(ans, it->second);
                }
                cout << ans << " ";
            }
        }
        cout << endl;
    }
    else{
        for(auto v: x){
            int pre = 0;
            if(v > highest_sum){
                pre += n-1;
                v -= highest_sum;
            }
            while(v > highest_sum){
                pre += n;
                v -= highest_sum;
            }
            // cout << imie(pre) << imie(v) << endl;
            int ans = inf;
            map<t64,int>::iterator it;
            for(it = sums.end()--;it != sums.begin(); it--){
                if(it->first >= v){
                    if(pre != 0){
                        ans = min(ans,1+pre + it->second);
                    }
                    else{
                        ans = min(ans,pre + it->second);
                    }
                }
                else break;
            }
            if(it->first >= v){
                if(pre != 0){
                    ans = min(ans,1+pre + it->second);
                }
                else{
                    ans = min(ans,pre + it->second);
                }
            }
            cout << ans << " ";
        }
        cout << endl;
    }
}

int main(){
        ios::sync_with_stdio(0);
	    cin.tie(0);
        int t = 1;
        cin >> t;
        while(t--){
            solve();
        }
        return 0;
}