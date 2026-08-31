#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cin>>n;
    int a[1001];
    for(int i=0;i<n;i++)
    {
        cin>>a[i];
    }
    int ans1,ans2;
    for(int i=0;i<n;++i) for(int j=0;j<n;j++)
    {
        if(i==j) continue;
        if(abs(a[i]-a[j])%(n-1)==0)
        {
            ans1=a[i];
            ans2=a[j];
            break;
        }
    }
    cout << ans1 << " " << ans2 << endl;
    return 0;
}
