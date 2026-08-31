#include <iostream>
using namespace std;

int a[100001] = {0}, b[100001] = {0};

int main () {
    int n, m, temp;
    cin >> n >> m;
    for (int i = 1; i <= m; i++) {cin >> temp; b[temp]++;}
    a[1] = b[1] == 0 ? 1 : 0;
    a[2] = b[2] == 0 ? (b[1] == 0 ? 2 : 1) : 0;
    for (int i = 3; i <= n; i++) if (!b[i]) a[i] = (a[i-1] + a[i-2]) % 1000000007;
    cout << a[n] << endl;
    return 0;
}