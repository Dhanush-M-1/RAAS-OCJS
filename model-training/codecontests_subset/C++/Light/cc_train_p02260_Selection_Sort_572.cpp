#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n;
    cin>>n;
    int a[n];
    int cnt=0;
    for(int i=0;i<n;i++)
        cin>>a[i];
    for(int i=0;i<n-1;i++)
    {
        int idx=i;
        for(int j=i;j<n;j++)
            if(a[j]<a[idx])
            idx=j;
        cnt+=i!=idx;
        swap(a[i],a[idx]);
    }
    for(int i=0;i<n;i++)
    {
        if(i)
        cout<<" ";
    cout<<a[i];
}
cout<<"\n";
cout<<cnt<<endl;
return 0;
    }

