#include <bits/stdc++.h>

using namespace std;

bool judge(int* a)
{
    int x[5] = {5, 7, 5, 7, 7};
    int i = 0;
    while(true)
    {
        if(i==5) return true;
        x[i] -= *a++;
        if(x[i]<0) return false;
        if(x[i]==0) i++;
    }
}

int main()
{
    int n;
    while(cin >> n, n)
    {
        int a[n];
        for(int i=0; i<n; i++)
        {
            string s;
            cin >> s;
            a[i] = s.size();
        }
        for(int i=0; i<n; i++)
        {
            if(judge(a+i))
            {
                cout << i+1 << endl;
                break;
            }
        }
    }
}