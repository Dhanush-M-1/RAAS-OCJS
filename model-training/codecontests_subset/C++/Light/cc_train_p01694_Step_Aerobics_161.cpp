#include <bits/stdc++.h>
using namespace std;

int main(){
    for (int n; cin >> n, n;) {
        int cur = 0, prev = 0, cnt = 0;
        while (n--) {
            string f; cin >> f;
            if (f == "lu") cur |= 2;
            if (f == "ru") cur |= 1;
            if (f == "ld") cur &= 1;
            if (f == "rd") cur &= 2;
            if ((cur ^ prev) == 3) cnt++, prev = cur;
        }
        cout << cnt << endl;
    }
}