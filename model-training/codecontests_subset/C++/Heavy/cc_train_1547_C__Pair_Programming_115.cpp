#include<bits/stdc++.h>
using namespace std;
int main() {
    int q; cin >> q;
    while (q--) {
        int k, n, m; cin >> k >> n >> m;
        vector<int>mono;
        vector<int>poly;
        vector<int>res;
        int maxl = 0;
        int al = 0;
        int i = 0, j = 0;
        while (i < n) {
            int a; cin >> a;
            mono.push_back(a);
            if (a == 0)
                al++;
            if (a > maxl)
                maxl = a;
            i++;
        }
        i = 0, j = 0;
        while (j < m) {
            int a; cin >> a;
            if (a == 0)
                al++;
            if (a > maxl)
                maxl = a;
            if (i < n && a >= mono[i]) {
                while (i < n && mono[i] <= a) {
                    res.push_back(mono[i]);
                    i++;
                }
            }
            res.push_back(a);
            j++;
        }
        while (i < n) {
            res.push_back(mono[i]);
            i++;
        }
        if (maxl <= k + al) {
            i = 0;
            string s = "";
            while (i < res.size()) {
                s += to_string(res[i]) + " ";
                if (res[i] == 0)
                    k++;
                else if (res[i] > k) {
                    cout << -1 << endl;
                    break;
                }
                i++;
            }
            if(i==res.size())
                cout << s << endl;
          
        }
        else {
            cout << -1 << endl;
        }

    }
    return 0;
}