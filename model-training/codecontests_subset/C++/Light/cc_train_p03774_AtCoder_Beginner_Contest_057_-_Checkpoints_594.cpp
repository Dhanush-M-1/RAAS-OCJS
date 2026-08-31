#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

#define rep(i,n) for(int i=0;i<n;i++)

int main() {
    int N, M;
    cin >> N >> M;
    int a[100], b[100], c[100], d[100];
    rep(i, N)cin >> a[i] >> b[i];
    rep(i, M)cin >> c[i] >> d[i];


    rep(i, N) {
        int p[100] = {};
        rep(j, M) {
            p[j] = abs(a[i] - c[j]) + abs(b[i] - d[j]);
        }
        cout << min_element(p, p + M) - p + 1 << endl;
    }
}