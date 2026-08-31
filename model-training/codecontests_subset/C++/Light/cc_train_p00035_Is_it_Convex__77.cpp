#include <cstdio>
#include <cmath>

struct line{
	double gr,in;
	int dir;
	line(){}
	line(double gradient,double intercept,int direction){
		gr=gradient;
		in=intercept;
		dir=direction;
	}
};

struct point{
	double x,y;
	point(){}
	point(double xx,double yy){
		x=xx;
		y=yy;
	}
};


double x[4],y[4];

line make_line(int i,int j){
	if(x[i]==x[j]){
		return line(0.0,x[i],1);
	}
	line l;
	l.gr=(y[j]-y[i])/(x[j]-x[i]);
	l.in=y[i]-x[i]*l.gr;
	l.dir=0;
	return l;
}

point cross(line a,line b){
	if(a.dir==1)return point(a.in,b.gr*a.in+b.in);
	if(b.dir==1)return point(b.in,a.gr*b.in+a.in);
	point p;
	p.x=-(b.in-a.in)/(b.gr-a.gr);
	p.y=a.gr*p.x+a.in;
	return p;
}

bool check(line a,int i,int j){
	line b=make_line(i,j);
	point p=cross(a,b);
	//printf("%d %d %f %f\n",i,j,p.x,p.y);
	if(b.dir==1){
		if((p.y-y[i])*(p.y-y[j])>=0.0)return false;
	}else{
		if((p.x-x[i])*(p.x-x[j])>=0.0)return false;
	}
	return true;
}

int main(void){
	while(~scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&x[0],&y[0],&x[1],&y[1],&x[2],&y[2],&x[3],&y[3])){
		bool flag=true;
		line l1=make_line(0,2),l2=make_line(1,3);
		if(!check(l1,1,3) || !check(l2,0,2))flag=false;
		printf("%s\n",flag?"YES":"NO");
	}
	return 0;
}