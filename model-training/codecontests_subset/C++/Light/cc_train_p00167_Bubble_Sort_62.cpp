#include<iostream>
using namespace std;
int n,a[100];
int main()
{
    while(cin>>n,n)
    {
        for(int i=0;i<n;i++)cin>>a[i];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)cnt+=a[i]>a[j];
        }
        cout<<cnt<<endl;
    }
}
