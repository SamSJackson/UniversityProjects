# Generated by Django 2.2.26 on 2022-03-07 14:30

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='AdminUser',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('firstName', models.CharField(max_length=40)),
                ('secondName', models.CharField(max_length=40)),
                ('password', models.CharField(max_length=20)),
                ('email', models.CharField(max_length=60, unique=True)),
                ('university', models.CharField(max_length=80)),
            ],
            options={
                'verbose_name_plural': 'Admin Users',
            },
        ),
        migrations.CreateModel(
            name='Course',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=80, unique=True)),
                ('level', models.IntegerField()),
                ('credits', models.IntegerField()),
                ('courseConvener', models.CharField(max_length=90)),
                ('courseNumber', models.CharField(max_length=30)),
            ],
            options={
                'verbose_name_plural': 'Courses',
            },
        ),
        migrations.CreateModel(
            name='StudentUser',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('firstName', models.CharField(max_length=40)),
                ('secondName', models.CharField(max_length=40)),
                ('password', models.CharField(max_length=20, unique=True)),
                ('email', models.CharField(max_length=60, unique=True)),
                ('university', models.CharField(max_length=80)),
                ('degree', models.CharField(max_length=30)),
                ('level', models.IntegerField(default=0)),
            ],
            options={
                'verbose_name_plural': 'StudentUsers',
            },
        ),
        migrations.CreateModel(
            name='Task',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=40)),
                ('completed', models.BooleanField(default=False)),
                ('dueDate', models.DateTimeField(auto_now_add=True, null=True, verbose_name='Creation date')),
                ('timePlanned', models.TimeField()),
            ],
            options={
                'verbose_name_plural': 'Tasks',
            },
        ),
        migrations.CreateModel(
            name='University',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=80)),
                ('Location', models.CharField(max_length=80)),
            ],
            options={
                'verbose_name_plural': 'Universites',
            },
        ),
    ]
