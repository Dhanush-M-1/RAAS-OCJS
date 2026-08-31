#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int n;

int main()
{
    cin >> n;
    map<pair<char, int>, int> mp;
    for (int i = 0; i < n; i++)
    {
        char a;
        int b;
        cin >> a >> b;
        pair<char, int> c = make_pair(a, b);
        mp[c]++;
    }
    char p[4] = {'S', 'H', 'C', 'D'};
    for (int i = 0; i < 4; i++)
    {
        for (int j = 1; j <= 13; j++)
        {
            pair<char, int> c = make_pair(p[i], j);
            if (mp[c] == 0)
                printf("%c %d\n", p[i], j);
        }
    }
}
