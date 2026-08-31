

#include <bits/stdc++.h>
#include <unordered_map>

//Author: Maximilian Paris
using namespace std;
typedef long long ll;
vector<pair<ll, ll>> prefix_sorted;
ll compare = 1e18;
struct sort_pred {
    bool operator()(const std::pair<int, int>& left, const std::pair<int, int>& right) {
        return left.second < right.second;
    }
};

int main() {
  int t; cin >> t;
 while (t--) {
        ll ans = 0;
        int n, m;
        cin >> n >> m;
       
        prefix_sorted = vector<pair<ll, ll>>(n);
        vector<ll> prefix(n) ;
        ll max_sum = 0;
        for (int i = 0; i < n; i++) {
            ll x;
            cin >> x;
            if (i > 0)
                prefix_sorted[i] = { x + prefix_sorted[i - 1].first,i}, prefix[i]= prefix_sorted[i].first;
            else prefix_sorted[i] = {x,i }, prefix[i] = prefix_sorted[i].first;
         
            max_sum = max(max_sum, prefix_sorted[i].first);
        }
        vector<ll> X(m);
        for (int i = 0; i < m; i++)cin >> X[i];

        int size_arr = n;
        ll max_prefix = prefix_sorted[n - 1].first;
        sort(prefix_sorted.begin(), prefix_sorted.end());
        unordered_map<ll, ll> pos;
        int j = 0;
        for (int i = 0; i < n; i++) {
           
            while (true) {
                if (pos[prefix_sorted[i].first] == 0 && prefix_sorted[i].first <= prefix[j])
                {
                    pos[prefix_sorted[i].first] = j + 1; break;
                }
                else if(prefix_sorted[i].first > prefix[j])j++;
                else { break; }
            }
        }
        for (int i = 0; i < m; i++) {
           
            if (X[i] > max_sum && max_prefix <= 0)
                cout << -1 << " ";
            else if (X[i] <= max_sum) {
               // int to = 0;
             pair<ll, ll> b = { X[i],0};
              int to=lower_bound(prefix_sorted.begin(), prefix_sorted.end(), b)- prefix_sorted.begin();
             
              
              
           
            //  for (int j = to; j < n; j++)ans = min(ans, prefix_sorted[j].second);
                cout << pos[prefix_sorted[to].first]-1 << " ";
            }
            else {
                
              ll cnt=  (ll(ceil((double(X[i] - max_sum)) / double(max_prefix))));
              ll check = X[i] - cnt* max_prefix; pair<ll, ll> b = {check,0 };
              int k = lower_bound(prefix_sorted.begin(), prefix_sorted.end(), b) - prefix_sorted.begin();
              
              //for (int j = k; j < n; j++)val = min(val, prefix_sorted[j].second);
          
                ll ans = pos[prefix_sorted[k].first]-1 +cnt* size_arr;
              //  for (int j = 0; j < n; j++) {
               //     ans = min(ans, (ll(ceil((double(X[i] - prefix[j]))/double(max_prefix))))* size_arr +j);
               // }
               

                cout << ans<< " ";
            }
        }




        cout << endl;

   }

    return 0x0;
}