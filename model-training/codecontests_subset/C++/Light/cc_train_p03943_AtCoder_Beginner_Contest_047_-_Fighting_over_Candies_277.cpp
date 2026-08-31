#include<bits/stdc++.h>
using namespace std;
int a[4];
int main()
{
    for(int i=1;i<=3;i++)cin>>a[i];
    sort(a+1,a+4);
    puts(a[1]+a[2]==a[3]?"Yes":"No");
    return 0;
}