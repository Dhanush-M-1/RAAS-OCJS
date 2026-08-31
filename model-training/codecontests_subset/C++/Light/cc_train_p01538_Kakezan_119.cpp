#include <iostream>

using namespace std;

typedef long long ll;

int solve(ll n)
{
    int cnt = 0;

    while (n / 10 != 0) {
        ll max_n = 0;

        for (int i = 10; n / i != 0; i *= 10) {
            ll tmp = (n / i) * (n % i);

            if (tmp > max_n)
                max_n = tmp;
        }
        n = max_n;
        cnt++;
    }

    return cnt;
}

int main()
{
    int q;

    cin >> q;
    while (q--) {
        ll n;

        cin >> n;
        cout << solve(n) << endl;
    }

    return 0;
}