#include <iostream>
#include <cstring>
#include <string>
using namespace std;

typedef long long ll;

int calc(int n) {
    int cnt = 0;
    while(n >= 10) {
        ll next = -1, r = 10;
        while (r < n) {
            next = max(next, ((ll)n/r) * (n%r));
            r *= 10;
        }
        n = next;
        cnt++;
    }
    return cnt;
}

int main() {
    int q,n;
    cin>>q;
    for (int i=0; i<q; ++i) {
        cin>>n;
        cout<<calc(n)<<endl;
    }
}