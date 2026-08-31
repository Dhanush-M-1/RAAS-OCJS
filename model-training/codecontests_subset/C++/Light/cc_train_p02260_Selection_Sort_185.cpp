#include<iostream>
using namespace std;
int a[105];
int main()
{
    int n;
    cin>>n;
    for(int i=0;i<n;i++)
    {
        cin>>a[i];
    }
    int ans=0;
    for(int i=0;i<n-1;i++)
    {
        int Min=i;
        for(int j=i;j<n;j++)
            if(a[j]<a[Min])
                Min=j;
        if(Min!=i)swap(a[i],a[Min]),ans++;
    }
    for(int i=0;i<n;i++)
    {
        if(i)cout<<' ';
        cout<<a[i];
    }
    cout<<endl;
    cout<<ans<<endl;
    return 0;
}

