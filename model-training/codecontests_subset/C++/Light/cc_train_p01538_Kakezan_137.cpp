#include <iostream>
using namespace std;

int rec(int n, int count) {
    if (n < 10) return count;
    int mx = 0;
    for (int i=10; i<=1000000; i*=10) {
        mx = max(mx, (n / i) * (n % i));
    }
    return rec(mx, count + 1);
}

int main() {
    int q, n;
    cin >> q;
    for (int i=0; i<q; ++i) {
        cin >> n;
        cout << rec(n, 0) << endl;
    }
    return 0;
}