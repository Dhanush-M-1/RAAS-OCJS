#include<bits/stdc++.h>
using namespace std;
int main()
{
long long int n,m,i,j,k,c,count,temp;
cin>>n>>m;
long long int a[n][2],b[m][2];
for(i=0;i<n;i++)
{
cin>>a[i][0]>>a[i][1];
}
for(i=0;i<m;i++)
{
cin>>b[i][0]>>b[i][1];
}
for(i=0;i<n;i++)
{
count=pow(10,15);
for(j=0;j<m;j++)
{
temp=abs(a[i][0]-b[j][0])+abs(a[i][1]-b[j][1]);
if(temp<count)
{
count=temp;
c=j;
}

}


cout<<c+1<<endl;
}






}